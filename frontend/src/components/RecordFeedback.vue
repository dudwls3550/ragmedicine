<template>

    <v-card outlined>
        <v-card-title>
            RecordFeedback
        </v-card-title>

        <v-card-text>
            <Number label="FeedbackStatisticsId" v-model="value.feedbackStatisticsId" :editMode="editMode"/>
            <QuestionAnswerId offline label="QuestionAnswerId" v-model="value.questionAnswerId" :editMode="editMode" @change="change"/>
            <FeedbackSatisfactionLevel offline label="SatisfactionLevel" v-model="value.satisfactionLevel" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordFeedback"
            >
                RecordFeedback
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
    name: 'RecordFeedbackCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.feedbackStatisticsId = 0;
        this.value.questionAnswerId = {};
        this.value.satisfactionLevel = {};
    },
    watch: {
    },
    methods: {
        recordFeedback() {
            this.$emit('recordFeedback', this.value);
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

