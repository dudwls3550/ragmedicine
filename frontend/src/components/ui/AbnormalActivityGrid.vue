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
            <ActivityDetectionConfiguration @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ActivityDetectionConfiguration>
            <AbnormalActivityReport @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AbnormalActivityReport>
            <AbnormalActivityQueue @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AbnormalActivityQueue>
            <ActivityDetectionReport @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ActivityDetectionReport>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>DetectedAt</th>
                        <th>ActivityType</th>
                        <th>Description</th>
                        <th>DetectedBy</th>
                        <th>DetectionResult</th>
                        <th>Status</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>사용자 ID</th>
                        <th>감사 로그 ID</th>
                        <th>피드백 알림 ID</th>
                        <th>사용자</th>
                        <th>감사 로그</th>
                        <th>피드백 알림</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="DetectedAt">{{ val.detectedAt }}</td>
                            <td class="whitespace-nowrap" label="ActivityType">{{ val.activityType }}</td>
                            <td class="whitespace-nowrap" label="Description">{{ val.description }}</td>
                            <td class="whitespace-nowrap" label="DetectedBy">{{ val.detectedBy }}</td>
                            <td class="whitespace-nowrap" label="DetectionResult">{{ val.detectionResult }}</td>
                            <td class="whitespace-nowrap" label="Status">{{ val.status }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="사용자">
                                <UserId :editMode="editMode" v-model="val.userId"></UserId>
                            </td>
                            <td class="whitespace-nowrap" label="감사 로그">
                                <AuditLogId :editMode="editMode" v-model="val.auditLogId"></AuditLogId>
                            </td>
                            <td class="whitespace-nowrap" label="피드백 알림">
                                <FeedbackNotificationId :editMode="editMode" v-model="val.feedbackNotificationId"></FeedbackNotificationId>
                            </td>
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
                        <div style="color:white; font-size:17px; font-weight:700;">AbnormalActivity 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <AbnormalActivity :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">AbnormalActivity 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="AbnormalActivityId" v-model="selectedRow.abnormalActivityId" :editMode="true"/>
                            <Date label="DetectedAt" v-model="selectedRow.detectedAt" :editMode="true"/>
                            <String label="Description" v-model="selectedRow.description" :editMode="true"/>
                            <String label="DetectedBy" v-model="selectedRow.detectedBy" :editMode="true"/>
                            <String label="DetectionResult" v-model="selectedRow.detectionResult" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <AbnormalActivityType offline label="ActivityType" v-model="selectedRow.activityType" :editMode="true"/>
                            <AbnormalActivityStatus offline label="Status" v-model="selectedRow.status" :editMode="true"/>
                            <UserId offline label="사용자 ID" v-model="selectedRow.userId" :editMode="true"/>
                            <AuditLogId offline label="감사 로그 ID" v-model="selectedRow.auditLogId" :editMode="true"/>
                            <FeedbackNotificationId offline label="피드백 알림 ID" v-model="selectedRow.feedbackNotificationId" :editMode="true"/>
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
    name: 'abnormalActivityGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'abnormalActivities',
    }),
    watch: {
    },
    methods:{
    }
}

</script>