<template>
  <div class="ato-animation-container">
    <div class="line"></div>
    <div class="line"></div>
    <div class="line"></div>
    <div class="line"></div>
    <div class="line"></div>
    <div class="line"></div>
    <div class="line"></div>
  </div>
</template>


<script setup lang="ts">

</script>
<style scoped lang="scss">

.ato-animation-container {
  position: absolute;
  top: 50%;
  left: 50%;
  transform: translate(-50%, -50%);
  min-height: 80px;
  display: grid;
  grid-template-columns: repeat(7, 1fr);
  gap: 10px;

  .line {
    width: 2px;
    height: 50px;
    min-height: 40px;
    background: #ecaa64;
    border-radius: 5px;
    @for $i from 1 through 7 {
      &:nth-child(#{$i}) {
        animation: bar 2s (0.2s * $i) infinite linear;
      }
      @keyframes bar {
        0% {
          background: #f677b0;
          margin-top: 25%;
          height: 10%;
        }

        50% {
          background: #f677b0;
          height: 100%;
          margin-top: 0;
        }

        100% {
          background: #f677b0;
          height: 10%;
          margin-top: 25%;
        }
      }
    }
  }

}


</style>
