<template>

    <v-card outlined>
        <v-card-title>
            DeleteExpiredLogs
        </v-card-title>

        <v-card-text>
            <Number label="LogRetentionPolicyId" v-model="value.logRetentionPolicyId" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="deleteExpiredLogs"
            >
                DeleteExpiredLogs
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
    name: 'DeleteExpiredLogsCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.logRetentionPolicyId = 0;
    },
    watch: {
    },
    methods: {
        deleteExpiredLogs() {
            this.$emit('deleteExpiredLogs', this.value);
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

