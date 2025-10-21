<template>

    <v-card outlined>
        <v-card-title>
            CheckAccess
        </v-card-title>

        <v-card-text>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <String label="ResourceIdentifier" v-model="value.resourceIdentifier" :editMode="editMode"/>
            <AuthorizationLevel offline label="RequiredLevel" v-model="value.requiredLevel" :editMode="editMode" @change="change"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="checkAccess"
            >
                CheckAccess
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
    name: 'CheckAccessCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = 0;
        this.value.resourceIdentifier = '';
        this.value.requiredLevel = {};
    },
    watch: {
    },
    methods: {
        checkAccess() {
            this.$emit('checkAccess', this.value);
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

