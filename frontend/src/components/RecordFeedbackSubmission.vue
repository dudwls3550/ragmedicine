<template>

    <v-card outlined>
        <v-card-title>
            RecordFeedbackSubmission
        </v-card-title>

        <v-card-text>
            <QuestionAnswerId offline label="QuestionAnswerId" v-model="value.questionAnswerId" :editMode="editMode" @change="change"/>
            <Boolean label="IsDissatisfied" v-model="value.isDissatisfied" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordFeedbackSubmission"
            >
                RecordFeedbackSubmission
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
    name: 'RecordFeedbackSubmissionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.questionAnswerId = {};
        this.value.isDissatisfied = false;
    },
    watch: {
    },
    methods: {
        recordFeedbackSubmission() {
            this.$emit('recordFeedbackSubmission', this.value);
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

