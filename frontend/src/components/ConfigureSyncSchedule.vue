<template>

    <v-card outlined>
        <v-card-title>
            ConfigureSyncSchedule
        </v-card-title>

        <v-card-text>
            <Number label="SyncId" v-model="value.syncId" :editMode="editMode"/>
            <String label="SyncCycle" v-model="value.syncCycle" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="configureSyncSchedule"
            >
                ConfigureSyncSchedule
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
    name: 'ConfigureSyncScheduleCommand',
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
    },
    watch: {
    },
    methods: {
        configureSyncSchedule() {
            this.$emit('configureSyncSchedule', this.value);
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

