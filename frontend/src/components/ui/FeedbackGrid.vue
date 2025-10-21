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
                <v-btn style="margin-left: 5px;" @click="submitFeedbackDialog = true" class="contrast-primary-text" small color="primary" >
                    <v-icon small>mdi-minus-circle-outline</v-icon>피드백 제출
                </v-btn>
                <v-dialog v-model="submitFeedbackDialog" width="500">
                    <SubmitFeedback
                        @closeDialog="submitFeedbackDialog = false"
                        @submitFeedback="submitFeedback"
                    ></SubmitFeedback>
                </v-dialog>
            </div>
            <FeedbackSummary @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></FeedbackSummary>
            <FeedbackDetail @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></FeedbackDetail>
            <FeedbackSummary @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></FeedbackSummary>
            <FeedbackDetail @search="search" style="margin-bottom: 10px; background-color: #ffffff;"></FeedbackDetail>
            <div class="mb-5 text-lg font-bold"></div>
            <div class="table-responsive">
                <v-table>
                    <thead>
                        <tr>
                        <th>Id</th>
                        <th>ResidentId</th>
                        <th>FeedbackContent</th>
                        <th>FeedbackType</th>
                        <th>FeedbackStatus</th>
                        <th>AdminNotificationSent</th>
                        <th>CreatedAt</th>
                        <th>UpdatedAt</th>
                        <th>사용자 ID</th>
                        <th>질문-답변 ID</th>
                        <th>사용자</th>
                        <th>질문-답변</th>
                        </tr>
                    </thead>
                    <tbody>
                        <tr v-for="(val, idx) in value" 
                            @click="changeSelectedRow(val)"
                            :key="val"  
                            :style="val === selectedRow ? 'background-color: rgb(var(--v-theme-primary), 0.2) !important;':''"
                        >
                            <td class="font-semibold">{{ idx + 1 }}</td>
                            <td class="whitespace-nowrap" label="ResidentId">{{ val.residentId }}</td>
                            <td class="whitespace-nowrap" label="FeedbackContent">{{ val.feedbackContent }}</td>
                            <td class="whitespace-nowrap" label="FeedbackType">{{ val.feedbackType }}</td>
                            <td class="whitespace-nowrap" label="FeedbackStatus">{{ val.feedbackStatus }}</td>
                            <td class="whitespace-nowrap" label="AdminNotificationSent">{{ val.adminNotificationSent }}</td>
                            <td class="whitespace-nowrap" label="CreatedAt">{{ val.createdAt }}</td>
                            <td class="whitespace-nowrap" label="UpdatedAt">{{ val.updatedAt }}</td>
                            <td class="whitespace-nowrap" label="사용자">
                                <UserId :editMode="editMode" v-model="val.userId"></UserId>
                            </td>
                            <td class="whitespace-nowrap" label="질문-답변">
                                <QuestionAnswerId :editMode="editMode" v-model="val.questionAnswerId"></QuestionAnswerId>
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
                        <div style="color:white; font-size:17px; font-weight:700;">Feedback 등록</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <Feedback :offline="offline"
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
                        <div style="color:white; font-size:17px; font-weight:700;">Feedback 수정</div>
                        <v-spacer></v-spacer>
                        <v-icon
                            color="white"
                            small
                            @click="closeDialog()"
                        >mdi-close</v-icon>
                    </v-toolbar>
                    <v-card-text>
                        <div>
                            <Number label="FeedbackId" v-model="selectedRow.feedbackId" :editMode="true"/>
                            <Number label="ResidentId" v-model="selectedRow.residentId" :editMode="true"/>
                            <String label="FeedbackContent" v-model="selectedRow.feedbackContent" :editMode="true"/>
                            <Boolean label="AdminNotificationSent" v-model="selectedRow.adminNotificationSent" :editMode="true"/>
                            <Date label="CreatedAt" v-model="selectedRow.createdAt" :editMode="true"/>
                            <Date label="UpdatedAt" v-model="selectedRow.updatedAt" :editMode="true"/>
                            <FeedbackType offline label="FeedbackType" v-model="selectedRow.feedbackType" :editMode="true"/>
                            <FeedbackStatus offline label="FeedbackStatus" v-model="selectedRow.feedbackStatus" :editMode="true"/>
                            <UserId offline label="사용자 ID" v-model="selectedRow.userId" :editMode="true"/>
                            <QuestionAnswerId offline label="질문-답변 ID" v-model="selectedRow.questionAnswerId" :editMode="true"/>
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
    name: 'feedbackGrid',
    mixins:[BaseGrid],
    components:{
    },
    data: () => ({
        path: 'feedbacks',
        submitFeedbackDialog: false,
    }),
    watch: {
    },
    methods:{
        async submitFeedback(params){
            try{
                var path = "submitFeedback".toLowerCase();
                var temp = await this.repository.invoke(this.selectedRow, path, params)
                // 스넥바 관련 수정 필요
                // this.$EventBus.$emit('show-success','SubmitFeedback 성공적으로 처리되었습니다.')
                for(var i = 0; i< this.value.length; i++){
                    if(this.value[i] == this.selectedRow){
                        this.value[i] = temp.data
                    }
                }
                this.submitFeedbackDialog = false
            }catch(e){
                console.log(e)
            }
        },
    }
}

</script>