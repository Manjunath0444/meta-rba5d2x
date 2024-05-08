SECTION = "kernel"
DESCRIPTION = "Linux kernel for Atmel ARM SoCs (aka AT91)"
SUMMARY = "Linux kernel for Atmel ARM SoCs (aka AT91)"
LICENSE = "MIT"
#LIC_FILES_CHKSUM = "file://COPYING;md5=d7810fab7487fb0aad327b76f1be7cd7"
LIC_FILES_CHKSUM = "file://COPYING.MIT;md5=3da9cfbcb788c80a0384361b4de20420"
inherit kernel

S = "${WORKDIR}/git"

SRCREV = "df483a14e05556553ef5d134e8eab1139ae57fbb"

#KBRANCH = "linux-rba5d2x"
SRC_URI = "git://github.com/Manjunath0444/Linux-Rba5d2x.git;protocol=https;branch=main"
FILESEXTRAPATHS_prepend := "${THISDIR}/${PN}:"
SRC_URI += "file://defconfig"
SRC_URI[md5sum] = "c420b5fdadece5f49d37e91646dc7617"
KERNEL_FEATURES_append = " some_kernel_feature another_kernel_feature"
python __anonymous () {
        if d.getVar('UBOOT_FIT_IMAGE', True) == 'xyes':
                d.appendVar('DEPENDS', ' u-boot-mkimage-native dtc-native')
}

do_deploy_append() {
        if [ "${UBOOT_FIT_IMAGE}" = "xyes" ]; then
                DTB_PATH="${B}/arch/${ARCH}/boot/dts/"
                if [ ! -e "${DTB_PATH}" ]; then
                        DTB_PATH="${B}/arch/${ARCH}/boot/"
                fi

                if [ -e ${S}/arch/${ARCH}/boot/dts/${MACHINE}.its ]; then
                        cp ${S}/arch/${ARCH}/boot/dts/${MACHINE}*.its ${DTB_PATH}
                        cd ${DTB_PATH}
                        mkimage -f ${MACHINE}.its ${MACHINE}.itb
                        install -m 0644 ${MACHINE}.itb ${DEPLOYDIR}/${MACHINE}.itb
                        cd -
                fi
        fi
        rm -rf ${S}/../image/boot/zImage
}

kernel_do_configure_append() {
        rm -f ${B}/.scmversion ${S}/.scmversion
        cd ${S}; git status; cd -
        rm -rf ${S}/../image/boot/zImage
}

do_shared_workdir () {
        rm -rf ${S}/../image/boot/zImage
        rm -rf ${S}/../deploy-linux-rba5d2x/zImage
}

addtask shared_workdir after do_deploy_append

