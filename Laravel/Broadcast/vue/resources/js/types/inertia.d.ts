import { PageProps } from '@inertiajs/core';
import { SharedData } from '.';

declare module '@vue/runtime-core' {
    interface ComponentCustomProperties {
        $page: { props: SharedData };
    }
}