// types/style.d.ts
import '@vue/runtime-dom'

declare module '@vue/runtime-dom' {
  interface CSSProperties {
    mixBlendMode?: 
      | 'normal' 
      | 'multiply' 
      | 'screen' 
      | 'overlay' 
      | 'darken' 
      | 'lighten'
      | 'color-dodge'
      | 'color-burn'
      | 'hard-light'
      | 'soft-light'
      | 'difference'
      | 'exclusion'
      | 'hue'
      | 'saturation'
      | 'color'
      | 'luminosity'
      | 'plus-darker'
  }
}