<template>
    <div>
        <Number
            label="SourceEvidenceId"
            v-model="value.sourceEvidenceId"
            :editMode="editMode"
        />
        <Number
            label="AnswerGenerationId"
            v-model="value.answerGenerationId"
            :editMode="editMode"
        />
        <String
            label="SourceTitle"
            v-model="value.sourceTitle"
            :editMode="editMode"
        />
        <String
            label="SourceUrl"
            v-model="value.sourceUrl"
            :editMode="editMode"
        />
        <Date
            label="RetrievedAt"
            v-model="value.retrievedAt"
            :editMode="editMode"
        />
        <EvidenceType
            offline
            label="SourceType"
            v-model="value.sourceType"
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
    name: 'SourceEvidence',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "sourceEvidences",
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
