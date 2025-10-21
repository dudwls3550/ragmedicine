<template>

    <v-card outlined>
        <v-card-title>
            DetectAbnormalActivity
        </v-card-title>

        <v-card-text>
            <UserId offline label="UserId" v-model="value.userId" :editMode="editMode" @change="change"/>
            <AbnormalActivityType offline label="ActivityType" v-model="value.activityType" :editMode="editMode" @change="change"/>
            <String label="Description" v-model="value.description" :editMode="editMode"/>
            <Date label="DetectedAt" v-model="value.detectedAt" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="detectAbnormalActivity"
            >
                DetectAbnormalActivity
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
    name: 'DetectAbnormalActivityCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = {};
        this.value.activityType = {};
        this.value.description = '';
        this.value.detectedAt = '2025-10-21';
    },
    watch: {
    },
    methods: {
        detectAbnormalActivity() {
            this.$emit('detectAbnormalActivity', this.value);
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

