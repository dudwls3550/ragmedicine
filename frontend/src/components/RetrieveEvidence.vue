<template>

    <v-card outlined>
        <v-card-title>
            RetrieveEvidence
        </v-card-title>

        <v-card-text>
            <Number label="AnswerGenerationId" v-model="value.answerGenerationId" :editMode="editMode"/>
            <String label="QuestionContent" v-model="value.questionContent" :editMode="editMode"/>
            <KnowledgeSyncId offline label="KnowledgeSyncId" v-model="value.knowledgeSyncId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="retrieveEvidence"
            >
                RetrieveEvidence
            </v-btn>
            
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="close"
            >
                Close
            </v-btn>
        </v-card-actions>
    </v-card>

</template>

<script>

export default {
    name: 'RetrieveEvidenceCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.answerGenerationId = 0;
        this.value.questionContent = '';
        this.value.knowledgeSyncId = {};
    },
    watch: {
    },
    methods: {
        retrieveEvidence() {
            this.$emit('retrieveEvidence', this.value);
        },
        close() {
            this.$emit('closeDialog');
        },
        change() {
            this.$emit("update:modelValue", this.value);
        },
    }
}
</script>

