<template>

    <v-card outlined>
        <v-card-title>
            AcknowledgeSyncFailure
        </v-card-title>

        <v-card-text>
            <Number label="AlertId" v-model="value.alertId" :editMode="editMode"/>
            <String label="AcknowledgedBy" v-model="value.acknowledgedBy" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="acknowledgeSyncFailure"
            >
                AcknowledgeSyncFailure
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
    name: 'AcknowledgeSyncFailureCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.alertId = 0;
        this.value.acknowledgedBy = '';
    },
    watch: {
    },
    methods: {
        acknowledgeSyncFailure() {
            this.$emit('acknowledgeSyncFailure', this.value);
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

