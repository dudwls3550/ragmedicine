<template>
    <div>
        <Number
            label="FeedbackStatisticsId"
            v-model="value.feedbackStatisticsId"
            :editMode="editMode"
        />
        <Number
            label="TotalFeedbackCount"
            v-model="value.totalFeedbackCount"
            :editMode="editMode"
        />
        <Number
            label="DissatisfiedFeedbackCount"
            v-model="value.dissatisfiedFeedbackCount"
            :editMode="editMode"
        />
        <Number
            label="DissatisfiedFeedbackRatio"
            v-model="value.dissatisfiedFeedbackRatio"
            :editMode="editMode"
        />
        <Date
            label="AggregatedAt"
            v-model="value.aggregatedAt"
            :editMode="editMode"
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
    name: 'FeedbackNotificationStatistics',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "feedbackNotificationStatistics",
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
