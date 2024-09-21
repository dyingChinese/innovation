<template>
  <div class="ato-animation-container">
    <span class="line"></span>
    <span class="line"></span>
    <span class="line"></span>
    <span class="line"></span>
    <div class="content">
      <slot>
        线条环绕
      </slot>
    </div>
  </div>
</template>


<script setup lang="ts">

</script>
<style scoped lang="scss">
.content {
  width: 320px;
  height: 320px;
  line-height: 320px;
  text-align: center;
  background-color: #cde;
}


.ato-animation-container {
  $properties: (
      (top: 0, left: 0, width: 100%, height: 3px, color: orange),
      (top: -100%, right: 0, width: 3px, height: 100%, color: red),
      (bottom: 0, right: 0, width: 100%, height: 3px, color: green),
      (bottom: -100%, left: 0, width: 3px, height: 100%, color: #3a86ff)
  );
  width: 320px;
  height: 320px;
  position: relative;
  overflow: hidden;

  .line {
    position: absolute;

    @for $index from 1 through length($properties) {
      $item: nth($properties, $index);
      &:nth-child(#{$index}) {
        background: linear-gradient(#{90deg + (90deg * ($index - 1))}, transparent, map-get($item, 'color'));
        animation: animate#{$index} 8s linear infinite;
        animation-delay: #{2s * ($index - 1)};
        @if $index == 1 {
          top: 0;
          left: 0;
          width: 100%;
          height: 3px;
        }
        @if $index == 2 {
          top: -100%;
          right: 0;
          width: 3px;
          height: 100%;
        }
        @if $index == 3 {
          bottom: 0;
          right: -100%;
          width: 100%;
          height: 3px;
        }
        @if $index == 4 {
          bottom: -100%;
          left: 0;
          width: 3px;
          height: 100%;
        }

        @keyframes animate#{$index} {
          0% {
            @if $index == 1 {
              left: -100%;
            } @else if $index == 2 {
              top: -100%;
            } @else if $index == 3 {
              right: -100%;
            } @else if $index == 4 {
              bottom: -100%;
            }
          }

          50%,
          100% {
            @if $index == 1 {
              left: 100%;
            } @else if $index == 2 {
              top: 100%;
            } @else if $index == 3 {
              right: 100%;
            } @else if $index == 4 {
              bottom: 100%;
            }
          }
        }

      }
    }
  }
}


</style>
