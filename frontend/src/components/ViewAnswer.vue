<template>

    <v-card outlined>
        <v-card-title>
            ViewAnswer
        </v-card-title>

        <v-card-text>
            <Number label="QuestionAnswerId" v-model="value.questionAnswerId" :editMode="editMode"/>
            <Number label="ResidentId" v-model="value.residentId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="viewAnswer"
            >
                ViewAnswer
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
    name: 'ViewAnswerCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.questionAnswerId = 0;
        this.value.residentId = 0;
    },
    watch: {
    },
    methods: {
        viewAnswer() {
            this.$emit('viewAnswer', this.value);
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

