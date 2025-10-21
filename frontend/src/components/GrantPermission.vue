<template>

    <v-card outlined>
        <v-card-title>
            GrantPermission
        </v-card-title>

        <v-card-text>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <AuthorizationLevel offline label="Role" v-model="value.role" :editMode="editMode" @change="change"/>
            <String label="PermissionType" v-model="value.permissionType" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="grantPermission"
            >
                GrantPermission
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
    name: 'GrantPermissionCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = 0;
        this.value.role = {};
        this.value.permissionType = '';
    },
    watch: {
    },
    methods: {
        grantPermission() {
            this.$emit('grantPermission', this.value);
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

