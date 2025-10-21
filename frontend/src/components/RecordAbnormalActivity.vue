<template>

    <v-card outlined>
        <v-card-title>
            RecordAbnormalActivity
        </v-card-title>

        <v-card-text>
            <Number label="AbnormalActivityId" v-model="value.abnormalActivityId" :editMode="editMode"/>
            <UserId offline label="UserId" v-model="value.userId" :editMode="editMode" @change="change"/>
            <AbnormalActivityType offline label="ActivityType" v-model="value.activityType" :editMode="editMode" @change="change"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
            <String label="DetectionResult" v-model="value.detectionResult" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="recordAbnormalActivity"
            >
                RecordAbnormalActivity
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
    name: 'RecordAbnormalActivityCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.abnormalActivityId = 0;
        this.value.userId = {};
        this.value.activityType = {};
        this.value.description = '';
        this.value.detectionResult = '';
    },
    watch: {
    },
    methods: {
        recordAbnormalActivity() {
            this.$emit('recordAbnormalActivity', this.value);
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

