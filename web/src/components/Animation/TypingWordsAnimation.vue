<template>
  <div class="ato-animation-container">
    <h1 class="ato-animation-container-text" >{{ text ? text : 'Hello World' }}</h1>
  </div>
</template>


<script setup lang="ts">
import {defineComponent, getCurrentInstance} from "vue";

const props = defineProps({
  // text: {
  //   type: String,
  //   required: true,
  // },
  cursorColor: {
    type: String,
    default: '#000',
  },
  infinite: {
    type: Boolean,
    default: true,
  },
  style: {
    type: Object,
    default: () => {
    },
  }
})
const text = "asndios dnasiodn"
if (!text || typeof text !== 'string') {
  new Error('text is required and must be a string');
}


// export default defineComponent({
//   setup(props, {slots, attrs}) {
//     const {textContent, cursorColor, infinite} = props;
//
//     const {style} = attrs;
//     if (!text || typeof text !== 'string') {
//       return new Error('text is required and must be a string');
//     }
//
//
const _style = {
  // ...props.style,
  // animationName:   'typingWords',
  // animationDuration: '5s',
  // animationIterationCount: infinite ? 'infinite' : 1,
  // width: text.length + 'em',
  // whiteSpace: `nowrap`,
  // overflow: `hidden`,
  /* 使用右边框作为打印的指针光标 */
  // borderRight: `1px solid  ${props.cursorColor ? props.cursorColor : '#000'}`,
  // paddingRight: `0.1em`,
}
//     // style.width = text.length + 'em';
//
//     // if (!slots.default || typeof slots.default !== 'function') {
//     //   return new Error('text is required and must be a string');
//     // {slots.default && slots.default()}
//     // }
//
//     return () => (
//         <div className="ato-animation-container">
//           <code className="ato-animation-container-text" style={_style}>{text ? text : 'Hello World'}</code>
//         </div>
//     )
//   }
// })
</script>


<style scoped lang="scss">

.ato-animation-container {
  &-text :local {
    //width: $worldCount * 1em;
    /* 加上两个动画，一个是打字动画，使用steps让字一个一个的出现，注意step和字数保持一致，光标动画也是同理，*/
    animation: typingWords 5s steps(12) infinite, cursor 0.5s steps(1) infinite;
    /* 要设置不允许换行，且溢出隐藏 */
    white-space: nowrap;
    overflow: hidden;
    /* 使用右边框作为打印的指针光标 */
    border-right: 1px solid #000;
  }

  @keyframes typingWords {
    0% {
      width: 0;
    }
  }
  @keyframes cursor {
    50% {
      border-color: transparent;
    }
  }
}

h1 {
  /* 本例12个文字(加标点符号)；有多少个文字，width就是多少个em */
  /* 加上两个动画，一个是打字动画，使用steps让字一个一个的出现，
   注意step和字数保持一致，光标动画也是同理，*/
  animation: typingWords 5s steps(12) infinite, cursor 0.5s steps(1) infinite;
  /* 要设置不允许换行，且溢出隐藏 */
  white-space: nowrap;
  overflow: hidden;
  /* 使用右边框作为打印的指针光标 */
  border-right: 1px solid #000;
}
</style>
<style>


</style>

