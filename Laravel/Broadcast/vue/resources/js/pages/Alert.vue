<script lang="ts" setup>
import { useEchoPublic } from '@laravel/echo-vue';
import { ref } from 'vue';

type AlertEvent = {
    message: string;
};

const alerts = ref<string[]>([]);

const echo = useEchoPublic('alert', '.alert', function (e: AlertEvent) {
    alerts.value.push(e.message);
});
</script>
<template>
    <h1>Alerts:</h1>
    <ul>
        <li v-for="alert in alerts">{{ alert }}</li>
    </ul>
</template>
