import react.FC
import react.Props
import mui.material.Typography
import mui.material.styles.TypographyVariant


val WIPComponent = FC<Props> {
    Typography {
        variant = TypographyVariant.h1
        + "Edit here"
    }
}