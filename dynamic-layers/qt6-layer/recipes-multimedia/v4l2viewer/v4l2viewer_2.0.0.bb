SUMMARY = "Allied Vision Video4Linux2 Viewer"
LICENSE = "GPL-2.0-or-later"
LIC_FILES_CHKSUM = "file://LICENSE.md;md5=435d4178fd08b25f9cf911f1c3a0ce1d"


inherit qt6-cmake

DEPENDS:append = " qtbase "

AVT_GIT_REPO = "V4L2Viewer"
AVT_GIT_BRANCH = "dev"
SRCREV = "f225a38228add956fd894d075a7bf6db1cf4d535"

require recipes-avt/common/avt_git.inc

SRC_URI += " \
            file://imx8mp-support.patch \
           "

S = "${WORKDIR}/git"

PV = "2.0.0-beta+git${SRCPV}"

do_install() {
	install -d ${D}${bindir}
	install -m 755 ${B}/V4L2Viewer ${D}${bindir}/V4L2Viewer
}