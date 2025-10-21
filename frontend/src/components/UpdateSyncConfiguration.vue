<template>

    <v-card outlined>
        <v-card-title>
            UpdateSyncConfiguration
        </v-card-title>

        <v-card-text>
            <Number label="SyncId" v-model="value.syncId" :editMode="editMode"/>
            <String label="SyncCycle" v-model="value.syncCycle" :editMode="editMode"/>
            <String label="ExternalDbStatus" v-model="value.externalDbStatus" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="updateSyncConfiguration"
            >
                UpdateSyncConfiguration
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
    name: 'UpdateSyncConfigurationCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.syncId = 0;
        this.value.syncCycle = '';
        this.value.externalDbStatus = '';
    },
    watch: {
    },
    methods: {
        updateSyncConfiguration() {
            this.$emit('updateSyncConfiguration', this.value);
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

