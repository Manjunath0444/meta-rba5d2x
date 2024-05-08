require u-boot-atmel.inc

DESCRIPTION = "U-Boot bootloader for RBA5D2X platform"
LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
LIC_FILES_CHKSUM = "file://${COMMON_LICENSE_DIR}/MIT;md5=0835ade698e0bcf8506ecda2f7b4f302"
#SRCREV = "1e7d2e5973c1fb780e55e28a801c6c574158ac14"
SRCREV = "79c6f20e2018b585488b9d437367ccc7a72760e7"

#SRCREV = "617bef4fa72a627d0f191515139f9e9258402150"
PV = "v2018.07-at91+git${SRCPV}"

S = "${WORKDIR}/git"

COMPATIBLE_MACHINE = '(sama5d3xek|sama5d3-xplained|sama5d3-xplained-sd|at91sam9x5ek|at91sam9rlek|at91sam9m10g45ek|sama5d4ek|sama5d4-xplained|sama5d4-xplained-sd|sama5d2-xplained|sama5d2-xplained-sd|sama5d2-xplained-emmc|sama5d2-ptc-ek|sama5d2-ptc-ek-sd|sama5d27-som1-ek|sama5d27-som1-ek-sd|rugged-board-a5d2x|rugged-board-a5d2x-sd1)'

UBRANCH = "main"
SRC_URI = "git://github.com/Manjunath0444/uboot-rba5d2x.git;protocol=https;branch=${UBRANCH}"

PACKAGE_ARCH = "${MACHINE_ARCH}"
