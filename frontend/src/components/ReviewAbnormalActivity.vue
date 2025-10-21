<template>

    <v-card outlined>
        <v-card-title>
            ReviewAbnormalActivity
        </v-card-title>

        <v-card-text>
            <Number label="AbnormalActivityId" v-model="value.abnormalActivityId" :editMode="editMode"/>
            <String label="ReviewNotes" v-model="value.reviewNotes" :editMode="editMode"/>
            <AbnormalActivityStatus offline label="NewStatus" v-model="value.newStatus" :editMode="editMode" @change="change"/>
            <String label="ActionTaken" v-model="value.actionTaken" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="reviewAbnormalActivity"
            >
                ReviewAbnormalActivity
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
    name: 'ReviewAbnormalActivityCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.abnormalActivityId = 0;
        this.value.reviewNotes = '';
        this.value.newStatus = {};
        this.value.actionTaken = '';
    },
    watch: {
    },
    methods: {
        reviewAbnormalActivity() {
            this.$emit('reviewAbnormalActivity', this.value);
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

