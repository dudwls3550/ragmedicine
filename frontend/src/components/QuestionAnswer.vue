<template>
    <div>
        <Number
            label="QuestionAnswerId"
            v-model="value.questionAnswerId"
            :editMode="editMode"
        />
        <Number
            label="ResidentId"
            v-model="value.residentId"
            :editMode="editMode"
        />
        <String
            label="QuestionContent"
            v-model="value.questionContent"
            :editMode="editMode"
        />
        <String
            label="ValidationResult"
            v-model="value.validationResult"
            :editMode="editMode"
        />
        <String
            label="AnswerContent"
            v-model="value.answerContent"
            :editMode="editMode"
        />
        <String
            label="AnswerSource"
            v-model="value.answerSource"
            :editMode="editMode"
        />
        <Date
            label="AnswerGeneratedAt"
            v-model="value.answerGeneratedAt"
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
        <QuestionStatus
            offline
            label="QuestionStatus"
            v-model="value.questionStatus"
            :editMode="editMode"
            @change="change"
        />
        <AnswerStatus
            offline
            label="AnswerStatus"
            v-model="value.answerStatus"
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
        <AnswerGenerationId
            offline
            label="답변 생성 ID"
            v-model="value.answerGenerationId"
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
    name: 'QuestionAnswer',
    mixins:[BaseEntity],
    components:{
    },
    
    data: () => ({
        path: "questionAnswers",
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
