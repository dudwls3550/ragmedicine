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
            <ActivityLogSummary @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></ActivityLogSummary>
            <AuditLogEntry @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></AuditLogEntry>
            <RetentionPolicyConfiguration @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></RetentionPolicyConfiguration>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>EventType</th>
                        <th>EventTimestamp</th>
                        <th>ActorId</th>
                        <th>ActorType</th>
                        <th>EventData</th>
                        <th>LogLevel</th>
                        <th>Source</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>RetentionExpiryAt</th>
                        <th>지식 동기화 ID</th>
                        <th>질문-답변 ID</th>
                        <th>답변 생성 ID</th>
                        <th>피드백 ID</th>
                        <th>사용자 ID</th>
                        <th>지식 동기화</th>
                        <th>질문-답변</th>
                        <th>답변 생성</th>
                        <th>피드백</th>
                        <th>사용자</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="EventType">{{ val.eventType }}</td>
                            <td class="whitespace-nowrap" label="EventTimestamp">{{ val.eventTimestamp }}</td>
                            <td class="whitespace-nowrap" label="ActorId">{{ val.actorId }}</td>
                            <td class="whitespace-nowrap" label="ActorType">{{ val.actorType }}</td>
                            <td class="whitespace-nowrap" label="EventData">{{ val.eventData }}</td>
                            <td class="whitespace-nowrap" label="LogLevel">{{ val.logLevel }}</td>
                            <td class="whitespace-nowrap" label="Source">{{ val.source }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="RetentionExpiryAt">{{ val.retentionExpiryAt }}</td>
                            <td class="whitespace-nowrap" label="지식 동기화">
                                <KnowledgeSyncId :editMode="editMode" v-model="val.knowledgeSyncId"></KnowledgeSyncId>
                            </td>
                            <td class="whitespace-nowrap" label="질문-답변">
                                <QuestionAnswerId :editMode="editMode" v-model="val.questionAnswerId"></QuestionAnswerId>
                            </td>
                            <td class="whitespace-nowrap" label="답변 생성">
                                <AnswerGenerationId :editMode="editMode" v-model="val.answerGenerationId"></AnswerGenerationId>
                            </td>
                            <td class="whitespace-nowrap" label="피드백">
                                <FeedbackId :editMode="editMode" v-model="val.feedbackId"></FeedbackId>
                            </td>
                            <td class="whitespace-nowrap" label="사용자">
                                <UserId :editMode="editMode" v-model="val.userId"></UserId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">AuditLog 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <AuditLog :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">AuditLog 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="AuditLogId" v-model="selectedRow.auditLogId" :editMode="true"/>
                            <Date label="EventTimestamp" v-model="selectedRow.eventTimestamp" :editMode="true"/>
                            <Number label="ActorId" v-model="selectedRow.actorId" :editMode="true"/>
                            <String label="ActorType" v-model="selectedRow.actorType" :editMode="true"/>
                            <String label="EventData" v-model="selectedRow.eventData" :editMode="true"/>
                            <Number label="LogLevel" v-model="selectedRow.logLevel" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <Date label="RetentionExpiryAt" v-model="selectedRow.retentionExpiryAt" :editMode="true"/>
                            <LogType offline label="EventType" v-model="selectedRow.eventType" :editMode="true"/>
                            <EventSource offline label="Source" v-model="selectedRow.source" :editMode="true"/>
                            <KnowledgeSyncId offline label="지식 동기화 ID" v-model="selectedRow.knowledgeSyncId" :editMode="true"/>
                            <QuestionAnswerId offline label="질문-답변 ID" v-model="selectedRow.questionAnswerId" :editMode="true"/>
                            <AnswerGenerationId offline label="답변 생성 ID" v-model="selectedRow.answerGenerationId" :editMode="true"/>
                            <FeedbackId offline label="피드백 ID" v-model="selectedRow.feedbackId" :editMode="true"/>
                            <UserId offline label="사용자 ID" v-model="selectedRow.userId" :editMode="true"/>
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
    name: 'auditLogGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'auditLogs',
    }),
    watch: {
    },
    methods:{
    }
}

</script>