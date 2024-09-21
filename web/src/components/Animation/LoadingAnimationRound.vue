<template>
  <div class="ato-animation-container">
    <div class="round"></div>
    <div class="round"></div>
    <div class="round"></div>
    <div class="round"></div>
    <div class="round"></div>
    <div class="round"></div>
    <div class="round"></div>
  </div>
</template>


<style scoped lang="scss">
.ato-animation-container {
  margin: 120px 0 0 240px;
  width: 75px;
  height: 75px;
  position: relative;
  /* transform-origin: 设置的效果搭配边框看，效果更加明显 */
  //border: 1px solid #e9e9e9;
}

.round {
  position: absolute;
  width: 13px;
  height: 13px;
  border-radius: 50%;
  background-color: rgb(241, 141, 157);
  /* 加上动画效果 */
  animation: circleRound 2.8s ease infinite;
  /* 设置旋转中心，搭配.wrap的border看 */
  transform-origin: 50% 75px;
  $colors: ('', rgb(199, 136, 185), rgb(153, 69, 223), rgb(69, 141, 223), rgb(69, 223, 203), rgb(100, 223, 69), rgb(223, 200, 69), rgb(223, 200, 69));
  @for $index from 1 through 7 {
    &:nth-child(#{$index}) {
      z-index: 7 - ($index - 1);
      height: 12px - ($index - 1);
      width: 12px - ($index - 1);
      animation-delay: .2s + .2s * ($index - 1);
      background-color: nth($colors, $index);
    }
  }
}

@keyframes circleRound {
  to {
    transform: rotate(1turn);
  }
}
</style>
