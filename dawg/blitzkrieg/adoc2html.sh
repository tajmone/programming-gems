#!/bin/bash

asciidoctor \
	--failure-level WARN \
	--timings \
	--verbose \
	--safe-mode unsafe \
	-a data-uri \
	-a experimental \
	-a icons=font \
	-a sectanchors \
	-a toc=left \
	-a reproducible \
	-a source-highlighter=rouge \
	-a rouge-style=thankful_eyes \
	dawg.asciidoc
