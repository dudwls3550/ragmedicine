<template>

    <v-card outlined>
        <v-card-title>
            SendSyncFailureAlert
        </v-card-title>

        <v-card-text>
            <Number label="SyncId" v-model="value.syncId" :editMode="editMode"/>
            <String label="FailureReason" v-model="value.failureReason" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="sendSyncFailureAlert"
            >
                SendSyncFailureAlert
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
    name: 'SendSyncFailureAlertCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.syncId = 0;
        this.value.failureReason = '';
    },
    watch: {
    },
    methods: {
        sendSyncFailureAlert() {
            this.$emit('sendSyncFailureAlert', this.value);
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

