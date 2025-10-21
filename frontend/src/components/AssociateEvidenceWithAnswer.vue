<template>

    <v-card outlined>
        <v-card-title>
            AssociateEvidenceWithAnswer
        </v-card-title>

        <v-card-text>
            <Number label="SourceEvidenceId" v-model="value.sourceEvidenceId" :editMode="editMode"/>
            <Number label="AnswerGenerationId" v-model="value.answerGenerationId" :editMode="editMode"/>
            <String label="SourceTitle" v-model="value.sourceTitle" :editMode="editMode"/>
            <String label="SourceUrl" v-model="value.sourceUrl" :editMode="editMode"/>
            <EvidenceType offline label="SourceType" v-model="value.sourceType" :editMode="editMode" @change="change"/>
            <Date label="RetrievedAt" v-model="value.retrievedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="associateEvidenceWithAnswer"
            >
                AssociateEvidenceWithAnswer
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
    name: 'AssociateEvidenceWithAnswerCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.sourceEvidenceId = 0;
        this.value.answerGenerationId = 0;
        this.value.sourceTitle = '';
        this.value.sourceUrl = '';
        this.value.sourceType = {};
        this.value.retrievedAt = '2025-10-21';
    },
    watch: {
    },
    methods: {
        associateEvidenceWithAnswer() {
            this.$emit('associateEvidenceWithAnswer', this.value);
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

