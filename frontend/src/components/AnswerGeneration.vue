<template>
    <div>
        <Number
            label="AnswerGenerationId"
            v-model="value.answerGenerationId"
            :editMode="editMode"
        />
        <String
            label="QuestionContent"
            v-model="value.questionContent"
            :editMode="editMode"
        />
        <String
            label="AnswerContent"
            v-model="value.answerContent"
            :editMode="editMode"
        />
        <Date
            label="CreatedAt"
            v-model="value.createdAt"
            :editMode="editMode"
        />
        <Number
            label="ReliabilityScore"
            v-model="value.reliabilityScore"
            :editMode="editMode"
        />
        <Boolean
            label="PersonalInfoFiltered"
            v-model="value.personalInfoFiltered"
            :editMode="editMode"
        />
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <div variant="outlined" class="my-2">
            <String
                label="SourceEvidenceIds"
                v-model="sourceEvidenceIdsInput"
                :editMode="editMode"
                @keydown.enter="addSourceEvidenceIdsList"
            />
            <v-card v-if="value.sourceEvidenceIds.length > 0" variant="outlined" class="pa-4 mt-2">
                <v-card-sub-title>
                    SourceEvidenceIds List
                </v-card-sub-title>
                <li v-for="(name, index) in value.sourceEvidenceIds" :key="index">
                    {{ name }}
                </li>
            </v-card>
            <v-row class="ma-0 pa-0 mt-2">
                <v-spacer></v-spacer>
                <v-btn @click="addSourceEvidenceIdsList">
                    SourceEvidenceIds 추가
                </v-btn>
            </v-row>
            
            <StringDetailGrid
                label="SourceEvidenceIds"
                offline
                v-model="value.sourceEvidenceIds"
                :editMode="editMode"
                @change="change"
            />
        </div>
        <v-divider class="border-opacity-50 my-divider my-2"></v-divider>
        <AnswerGenerationStatus
            offline
            label="Status"
            v-model="value.status"
            :editMode="editMode"
            @change="change"
        />
        <SourceEvidenceId
            offline
            label="출처 정보 ID"
            v-model="value.sourceEvidenceId"
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
    name: 'AnswerGeneration',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "answerGenerations",
        sourceEvidenceIdsInput: null,
        value: {
            sourceEvidenceIds: [],
        }
    }),
    created(){
    },
    computed:{
    },
    methods: {
        addSourceEvidenceIdsList() {
            if (this.sourceEvidenceIdsInput !== null && this.sourceEvidenceIdsInput !== '') {
                this.value.sourceEvidenceIds.push(this.sourceEvidenceIdsInput);
                this.sourceEvidenceIdsInput = null; // null로 초기화
            }
        },
    },
}
</script>
