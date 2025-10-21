<template>

    <v-card outlined>
        <v-card-title>
            SubmitFollowUpQuestion
        </v-card-title>

        <v-card-text>
            <Number label="AnswerGenerationId" v-model="value.answerGenerationId" :editMode="editMode"/>
            <String label="FollowUpQuestionContent" v-model="value.followUpQuestionContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="submitFollowUpQuestion"
            >
                SubmitFollowUpQuestion
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
    name: 'SubmitFollowUpQuestionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.answerGenerationId = 0;
        this.value.followUpQuestionContent = '';
    },
    watch: {
    },
    methods: {
        submitFollowUpQuestion() {
            this.$emit('submitFollowUpQuestion', this.value);
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

