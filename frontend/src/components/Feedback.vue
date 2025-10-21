<template>
    <div>
        <Number
            label="FeedbackId"
            v-model="value.feedbackId"
            :editMode="editMode"
        />
        <Number
            label="ResidentId"
            v-model="value.residentId"
            :editMode="editMode"
        />
        <String
            label="FeedbackContent"
            v-model="value.feedbackContent"
            :editMode="editMode"
        />
        <Boolean
            label="AdminNotificationSent"
            v-model="value.adminNotificationSent"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Date
            label="UpdatedAt"
            v-model="value.updatedAt"
            :editMode="editMode"
        />
        <FeedbackType
            offline
            label="FeedbackType"
            v-model="value.feedbackType"
            :editMode="editMode"
            @change="change"
        />
        <FeedbackStatus
            offline
            label="FeedbackStatus"
            v-model="value.feedbackStatus"
            :editMode="editMode"
            @change="change"
        />
        <UserId
            offline
            label="사용자 ID"
            v-model="value.userId"
            :editMode="editMode"
            @change="change"
        />
        <QuestionAnswerId
            offline
            label="질문-답변 ID"
            v-model="value.questionAnswerId"
            :editMode="editMode"
            @change="change"
        />
        <v-row class="ma-0 pa-0">
            <v-spacer></v-spacer>
            <v-btn width="64px" color="primary" @click="save">
                저장
            </v-btn>
        </v-row>
    </div>
</template>


<script>
import BaseEntity from './base-ui/BaseEntity.vue'

export default {
    name: 'Feedback',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "feedbacks",
        value: {
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
    },
}
</script>
