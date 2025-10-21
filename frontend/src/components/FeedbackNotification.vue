<template>
    <div>
        <Number
            label="NotificationId"
            v-model="value.notificationId"
            :editMode="editMode"
        />
        <Number
            label="FeedbackStatisticsId"
            v-model="value.feedbackStatisticsId"
            :editMode="editMode"
        />
        <Number
            label="AdminId"
            v-model="value.adminId"
            :editMode="editMode"
        />
        <Number
            label="EventLevel"
            v-model="value.eventLevel"
            :editMode="editMode"
        />
        <Date
            label="TriggeredAt"
            v-model="value.triggeredAt"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <NotificationStatus
            offline
            label="NotificationStatus"
            v-model="value.notificationStatus"
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
        <FeedbackId
            offline
            label="피드백 ID"
            v-model="value.feedbackId"
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
    name: 'FeedbackNotification',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "feedbackNotifications",
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
