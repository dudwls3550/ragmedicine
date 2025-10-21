<template>

    <v-card outlined>
        <v-card-title>
            RecordLog
        </v-card-title>

        <v-card-text>
            <LogType offline label="EventType" v-model="value.eventType" :editMode="editMode" @change="change"/>
            <Number label="ActorId" v-model="value.actorId" :editMode="editMode"/>
            <String label="EventData" v-model="value.eventData" :editMode="editMode"/>
            <Number label="LogLevel" v-model="value.logLevel" :editMode="editMode"/>
            <EventSource offline label="Source" v-model="value.source" :editMode="editMode" @change="change"/>
            <QuestionAnswerId offline label="QuestionAnswerId" v-model="value.questionAnswerId" :editMode="editMode" @change="change"/>
            <FeedbackId offline label="FeedbackId" v-model="value.feedbackId" :editMode="editMode" @change="change"/>
            <KnowledgeSyncId offline label="KnowledgeSyncId" v-model="value.knowledgeSyncId" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordLog"
            >
                RecordLog
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
    name: 'RecordLogCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.eventType = {};
        this.value.actorId = 0;
        this.value.eventData = '';
        this.value.logLevel = 0;
        this.value.source = {};
        this.value.questionAnswerId = {};
        this.value.feedbackId = {};
        this.value.knowledgeSyncId = {};
    },
    watch: {
    },
    methods: {
        recordLog() {
            this.$emit('recordLog', this.value);
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

