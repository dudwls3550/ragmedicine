<template>

    <v-card outlined>
        <v-card-title>
            GrantAccess
        </v-card-title>

        <v-card-text>
            <Number label="UserId" v-model="value.userId" :editMode="editMode"/>
            <AuthorizationLevel offline label="Level" v-model="value.level" :editMode="editMode" @change="change"/>
            <String label="Role" v-model="value.role" :editMode="editMode"/>
            <String label="PermissionType" v-model="value.permissionType" :editMode="editMode"/>
        </v-card-text>

        <v-card-actions>
            <v-spacer></v-spacer>
            <v-btn
                    color="deep-purple lighten-2"
                    text
                    @click="grantAccess"
            >
                GrantAccess
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
    name: 'GrantAccessCommand',
    components:{
    },
    props: {},
    data: () => ({
        editMode: true,
        value: {},
    }),
    created() {
        this.value.userId = 0;
        this.value.level = {};
        this.value.role = '';
        this.value.permissionType = '';
    },
    watch: {
    },
    methods: {
        grantAccess() {
            this.$emit('grantAccess', this.value);
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

