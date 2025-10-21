<template>

    <v-card outlined>
        <v-card-title>
            AnalyzeUserActivity
        </v-card-title>

        <v-card-text>
            <UserId offline label="UserId" v-model="value.userId" :editMode="editMode" @change="change"/>
            <String label="ActivityLogReference" v-model="value.activityLogReference" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="analyzeUserActivity"
            >
                AnalyzeUserActivity
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
    name: 'AnalyzeUserActivityCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = {};
        this.value.activityLogReference = '';
    },
    watch: {
    },
    methods: {
        analyzeUserActivity() {
            this.$emit('analyzeUserActivity', this.value);
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

