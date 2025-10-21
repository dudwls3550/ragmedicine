<template>

    <v-card outlined>
        <v-card-title>
            RevokePermission
        </v-card-title>

        <v-card-text>
            <Number label="AuthorizationId" v-model="value.authorizationId" :editMode="editMode"/>
            <String label="RevokedBy" v-model="value.revokedBy" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="revokePermission"
            >
                RevokePermission
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
    name: 'RevokePermissionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.authorizationId = 0;
        this.value.revokedBy = '';
    },
    watch: {
    },
    methods: {
        revokePermission() {
            this.$emit('revokePermission', this.value);
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

