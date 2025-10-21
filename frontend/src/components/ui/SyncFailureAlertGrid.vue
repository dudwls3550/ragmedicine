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
            <ActiveFailureAlerts @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ActiveFailureAlerts>
            <AlertHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AlertHistory>
            <ActiveFailureAlerts @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ActiveFailureAlerts>
            <AlertHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AlertHistory>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>SyncId</th>
                        <th>FailureReason</th>
                        <th>AlertStatus</th>
                        <th>NotifiedAt</th>
                        <th>지식 동기화 ID</th>
                        <th>지식 동기화</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="SyncId">{{ val.syncId }}</td>
                            <td class="whitespace-nowrap" label="FailureReason">{{ val.failureReason }}</td>
                            <td class="whitespace-nowrap" label="AlertStatus">{{ val.alertStatus }}</td>
                            <td class="whitespace-nowrap" label="NotifiedAt">{{ val.notifiedAt }}</td>
                            <td class="whitespace-nowrap" label="지식 동기화">
                                <KnowledgeSyncId :editMode="editMode" v-model="val.knowledgeSyncId"></KnowledgeSyncId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">SyncFailureAlert 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <SyncFailureAlert :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">SyncFailureAlert 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="AlertId" v-model="selectedRow.alertId" :editMode="true"/>
                            <Number label="SyncId" v-model="selectedRow.syncId" :editMode="true"/>
                            <String label="FailureReason" v-model="selectedRow.failureReason" :editMode="true"/>
                            <Date label="NotifiedAt" v-model="selectedRow.notifiedAt" :editMode="true"/>
                            <AlertStatus offline label="AlertStatus" v-model="selectedRow.alertStatus" :editMode="true"/>
                            <KnowledgeSyncId offline label="지식 동기화 ID" v-model="selectedRow.knowledgeSyncId" :editMode="true"/>
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
    name: 'syncFailureAlertGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'syncFailureAlerts',
    }),
    watch: {
    },
    methods:{
    }
}

</script>