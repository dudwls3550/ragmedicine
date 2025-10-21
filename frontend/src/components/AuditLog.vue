<template>
    <div>
        <Number
            label="AuditLogId"
            v-model="value.auditLogId"
            :editMode="editMode"
        />
        <Date
            label="EventTimestamp"
            v-model="value.eventTimestamp"
            :editMode="editMode"
        />
        <Number
            label="ActorId"
            v-model="value.actorId"
            :editMode="editMode"
        />
        <String
            label="ActorType"
            v-model="value.actorType"
            :editMode="editMode"
        />
        <String
            label="EventData"
            v-model="value.eventData"
            :editMode="editMode"
        />
        <Number
            label="LogLevel"
            v-model="value.logLevel"
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
        <Date
            label="RetentionExpiryAt"
            v-model="value.retentionExpiryAt"
            :editMode="editMode"
        />
        <LogType
            offline
            label="EventType"
            v-model="value.eventType"
            :editMode="editMode"
            @change="change"
        />
        <EventSource
            offline
            label="Source"
            v-model="value.source"
            :editMode="editMode"
            @change="change"
        />
        <KnowledgeSyncId
            offline
            label="지식 동기화 ID"
            v-model="value.knowledgeSyncId"
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
        <AnswerGenerationId
            offline
            label="답변 생성 ID"
            v-model="value.answerGenerationId"
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
        <UserId
            offline
            label="사용자 ID"
            v-model="value.userId"
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
    name: 'AuditLog',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "auditLogs",
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
