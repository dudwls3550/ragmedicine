<template>

    <v-card outlined>
        <v-card-title>
            TriggerNotification
        </v-card-title>

        <v-card-text>
            <Number label="FeedbackStatisticsId" v-model="value.feedbackStatisticsId" :editMode="editMode"/>
            <Number label="AdminId" v-model="value.adminId" :editMode="editMode"/>
            <Number label="EventLevel" v-model="value.eventLevel" :editMode="editMode"/>
            <FeedbackId offline label="FeedbackId" v-model="value.feedbackId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="triggerNotification"
            >
                TriggerNotification
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
    name: 'TriggerNotificationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.feedbackStatisticsId = 0;
        this.value.adminId = 0;
        this.value.eventLevel = 0;
        this.value.feedbackId = {};
    },
    watch: {
    },
    methods: {
        triggerNotification() {
            this.$emit('triggerNotification', this.value);
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

