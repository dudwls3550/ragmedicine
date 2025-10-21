<template>

    <v-card outlined>
        <v-card-title>
            ConfigureThreshold
        </v-card-title>

        <v-card-text>
            <Number label="FeedbackStatisticsId" v-model="value.feedbackStatisticsId" :editMode="editMode"/>
            <Number label="DissatisfactionRatioThreshold" v-model="value.dissatisfactionRatioThreshold" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="configureThreshold"
            >
                ConfigureThreshold
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
    name: 'ConfigureThresholdCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.feedbackStatisticsId = 0;
        this.value.dissatisfactionRatioThreshold = 0;
    },
    watch: {
    },
    methods: {
        configureThreshold() {
            this.$emit('configureThreshold', this.value);
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

