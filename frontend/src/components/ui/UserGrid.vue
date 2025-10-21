<template>
    <v-container>
        <v-snackbar
            v-model="snackbar.status"
            :timeout="snackbar.timeout"
            :color="snackbar.color"
        >
            
            <v-btn style="margin-left: 80px;" text @click="snackbar.status = false">
                Close
            </v-btn>
        </v-snackbar>
        <div class="panel">
            <div class="gs-bundle-of-buttons" style="max-height:10vh;">
                <v-btn @click="addNewRow" @class="contrast-primary-text" small color="primary">
                    <v-icon small style="margin-left: -5px;">mdi-plus</v-icon>등록
                </v-btn>
                <v-btn :disabled="!selectedRow" style="margin-left: 5px;" @click="openEditDialog()" class="contrast-primary-text" small color="primary">
                    <v-icon small>mdi-pencil</v-icon>수정
                </v-btn>
            </div>
            <UserDetail @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserDetail>
            <UserActivityHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserActivityHistory>
            <UserList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserList>
            <UserList @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserList>
            <UserDetail @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserDetail>
            <UserActivityLog @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></UserActivityLog>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>EncryptedPassword</th>
                        <th>Role</th>
                        <th>Status</th>
                        <th>AbnormalActivityCount</th>
                        <th>FeedbackDissatisfactionCount</th>
                        <th>LastLoginAt</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>SuspendedAt</th>
                        <th>SuspendedReason</th>
                        <th>Profile</th>
                        <th>Verification</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="EncryptedPassword">{{ val.encryptedPassword }}</td>
                            <td class="whitespace-nowrap" label="Role">{{ val.role }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="AbnormalActivityCount">{{ val.abnormalActivityCount }}</td>
                            <td class="whitespace-nowrap" label="FeedbackDissatisfactionCount">{{ val.feedbackDissatisfactionCount }}</td>
                            <td class="whitespace-nowrap" label="LastLoginAt">{{ val.lastLoginAt }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="SuspendedAt">{{ val.suspendedAt }}</td>
                            <td class="whitespace-nowrap" label="SuspendedReason">{{ val.suspendedReason }}</td>
                            <td class="whitespace-nowrap" label="Profile">{{ val.profile }}</td>
                            <td class="whitespace-nowrap" label="Verification">{{ val.verification }}</td>
                            <v-row class="ma-0 pa-4 align-center">
                                <v-spacer></v-spacer>
                                <Icon style="cursor: pointer;" icon="mi:delete" @click="deleteRow(val)" />
                            </v-row>
                        </tr>
                    </tbody>
                </v-table>
            </div>
        </div>
        <v-col>
            <v-dialog
                v-model="openDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">User 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <User :offline="offline"
                            :isNew="!value.idx"
                            :editMode="true"
                            :inList="false"
                            v-model="newValue"
                            @add="append"
                        />
                    </v-card-text>
                </v-card>
            </v-dialog>
            <v-dialog
                v-model="editDialog"
                transition="dialog-bottom-transition"
                width="35%"
            >
                <v-card>
                    <v-toolbar
                        color="primary"
                        class="elevation-0 pa-4"
                        height="50px"
                    >
                        <div style="color:white; font-size:17px; font-weight:700;">User 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="UserId" v-model="selectedRow.userId" :editMode="true"/>
                            <String label="EncryptedPassword" v-model="selectedRow.encryptedPassword" :editMode="true"/>
                            <Number label="AbnormalActivityCount" v-model="selectedRow.abnormalActivityCount" :editMode="true"/>
                            <Number label="FeedbackDissatisfactionCount" v-model="selectedRow.feedbackDissatisfactionCount" :editMode="true"/>
                            <Date label="LastLoginAt" v-model="selectedRow.lastLoginAt" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <Date label="SuspendedAt" v-model="selectedRow.suspendedAt" :editMode="true"/>
                            <String label="SuspendedReason" v-model="selectedRow.suspendedReason" :editMode="true"/>
                            <UserRole offline label="Role" v-model="selectedRow.role" :editMode="true"/>
                            <UserStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <UserProfile offline label="Profile" v-model="selectedRow.profile" :editMode="true"/>
                            <MedicalInstitutionVerification offline label="Verification" v-model="selectedRow.verification" :editMode="true"/>
                            <v-divider class="border-opacity-100 my-divider"></v-divider>
                            <v-layout row justify-end>
                                <v-btn
                                    width="64px"
                                    color="primary"
                                    @click="save"
                                >
                                    수정
                                </v-btn>
                            </v-layout>
                        </div>
                    </v-card-text>
                </v-card>
            </v-dialog>
        </v-col>
    </v-container>
</template>

<script>
import { ref } from 'vue';
import { useTheme } from 'vuetify';
import BaseGrid from '../base-ui/BaseGrid.vue'


export default {
    name: 'userGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'users',
    }),
    watch: {
    },
    methods:{
    }
}

</script>