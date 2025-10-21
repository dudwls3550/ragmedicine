<template>

    <v-card outlined>
        <v-card-title>
            SubmitAnswerFeedback
        </v-card-title>

        <v-card-text>
            <Number label="AnswerGenerationId" v-model="value.answerGenerationId" :editMode="editMode"/>
            <String label="FeedbackType" v-model="value.feedbackType" :editMode="editMode"/>
            <String label="FeedbackContent" v-model="value.feedbackContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="submitAnswerFeedback"
            >
                SubmitAnswerFeedback
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
    name: 'SubmitAnswerFeedbackCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.answerGenerationId = 0;
        this.value.feedbackType = '';
        this.value.feedbackContent = '';
    },
    watch: {
    },
    methods: {
        submitAnswerFeedback() {
            this.$emit('submitAnswerFeedback', this.value);
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

