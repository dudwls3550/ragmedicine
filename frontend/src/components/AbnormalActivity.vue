<template>
    <div>
        <Number
            label="AbnormalActivityId"
            v-model="value.abnormalActivityId"
            :editMode="editMode"
        />
        <Date
            label="DetectedAt"
            v-model="value.detectedAt"
            :editMode="editMode"
        />
        <String
            label="Description"
            v-model="value.description"
            :editMode="editMode"
        />
        <String
            label="DetectedBy"
            v-model="value.detectedBy"
            :editMode="editMode"
        />
        <String
            label="DetectionResult"
            v-model="value.detectionResult"
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
        <AbnormalActivityType
            offline
            label="ActivityType"
            v-model="value.activityType"
            :editMode="editMode"
            @change="change"
        />
        <AbnormalActivityStatus
            offline
            label="Status"
            v-model="value.status"
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
        <AuditLogId
            offline
            label="감사 로그 ID"
            v-model="value.auditLogId"
            :editMode="editMode"
            @change="change"
        />
        <FeedbackNotificationId
            offline
            label="피드백 알림 ID"
            v-model="value.feedbackNotificationId"
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
    name: 'AbnormalActivity',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "abnormalActivities",
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
