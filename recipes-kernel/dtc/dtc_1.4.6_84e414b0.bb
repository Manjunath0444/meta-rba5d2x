require dtc.inc

LIC_FILES_CHKSUM = "file://GPL;md5=94d55d512a9ba36caa9b7df079bae19f \
		    file://libfdt/libfdt.h;beginline=3;endline=52;md5=fb360963151f8ec2d6c06b055bcbb68c"


SRCREV = "84e414b0b5bcea3a82875d79cc15520440e1e49b"

S = "${WORKDIR}/git"

BBCLASSEXTEND = "native nativesdk"
