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
            <NotificationHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></NotificationHistory>
            <NotificationAlertStatus @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></NotificationAlertStatus>
            <NotificationHistory @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></NotificationHistory>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>FeedbackStatisticsId</th>
                        <th>AdminId</th>
                        <th>EventLevel</th>
                        <th>NotificationStatus</th>
                        <th>TriggeredAt</th>
                        <th>CreatedAt</th>
                        <th>사용자 ID</th>
                        <th>피드백 ID</th>
                        <th>사용자</th>
                        <th>피드백</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="FeedbackStatisticsId">{{ val.feedbackStatisticsId }}</td>
                            <td class="whitespace-nowrap" label="AdminId">{{ val.adminId }}</td>
                            <td class="whitespace-nowrap" label="EventLevel">{{ val.eventLevel }}</td>
                            <td class="whitespace-nowrap" label="NotificationStatus">{{ val.notificationStatus }}</td>
                            <td class="whitespace-nowrap" label="TriggeredAt">{{ val.triggeredAt }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="사용자">
                                <UserId :editMode="editMode" v-model="val.userId"></UserId>
                            </td>
                            <td class="whitespace-nowrap" label="피드백">
                                <FeedbackId :editMode="editMode" v-model="val.feedbackId"></FeedbackId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">FeedbackNotification 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <FeedbackNotification :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">FeedbackNotification 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="NotificationId" v-model="selectedRow.notificationId" :editMode="true"/>
                            <Number label="FeedbackStatisticsId" v-model="selectedRow.feedbackStatisticsId" :editMode="true"/>
                            <Number label="AdminId" v-model="selectedRow.adminId" :editMode="true"/>
                            <Number label="EventLevel" v-model="selectedRow.eventLevel" :editMode="true"/>
                            <Date label="TriggeredAt" v-model="selectedRow.triggeredAt" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <NotificationStatus offline label="NotificationStatus" v-model="selectedRow.notificationStatus" :editMode="true"/>
                            <UserId offline label="사용자 ID" v-model="selectedRow.userId" :editMode="true"/>
                            <FeedbackId offline label="피드백 ID" v-model="selectedRow.feedbackId" :editMode="true"/>
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
    name: 'feedbackNotificationGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'feedbackNotifications',
    }),
    watch: {
    },
    methods:{
    }
}

</script>