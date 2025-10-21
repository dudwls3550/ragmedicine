<template>

    <v-card outlined>
        <v-card-title>
            SubmitQuestion
        </v-card-title>

        <v-card-text>
            <Number label="ResidentId" v-model="value.residentId" :editMode="editMode"/>
            <String label="QuestionContent" v-model="value.questionContent" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="submitQuestion"
            >
                SubmitQuestion
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
    name: 'SubmitQuestionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.residentId = 0;
        this.value.questionContent = '';
    },
    watch: {
    },
    methods: {
        submitQuestion() {
            this.$emit('submitQuestion', this.value);
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

