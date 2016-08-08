#!/bin/bash

source . ./ci/common.sh

if [ "$TRAVIS" = "true" ]; then
  S3_BASE="http://stormpath-sdk-java-travis-setup.s3-website-us-east-1.amazonaws.com"
  ENC_TARBALL="stormpath_travis_setup.tar.enc"
  AUTHOR=$(git show --format="%ae" | head -n 1)
  MIDDLE="/"

  if [ $TRAVIS_BRANCH != master ]; then
    MIDDLE="/$AUTHOR/"
  fi

  export ENC_TARBALL_URL=$S3_BASE$MIDDLE$ENC_TARBALL

  wget $ENC_TARBALL_URL

  if [ -e $ENC_TARBALL ]; then
    echo "$ENC_TARBALL_URL found. Proceeding.";
  else
    echo "$ENC_TARBALL_URL not found. Exiting."; exit 1;
  fi

  openssl aes-256-cbc -K $encrypted_0b7f5d43be1f_key -iv $encrypted_0b7f5d43be1f_iv -in stormpath_travis_setup.tar.enc -out stormpath_travis_setup.tar -d
  tar xvf stormpath_travis_setup.tar
  source env.sh
  cp id_rsa_stormpath.github.io ~/.ssh/id_rsa
  chmod 600 ~/.ssh/id_rsa
  mkdir -p ~/.stormpath/clover
  cp clover.license ~/.stormpath/clover
fi

#Using xmllint is faster than invoking maven
export RELEASE_VERSION="$(xmllint --xpath "//*[local-name()='project']/*[local-name()='version']/text()" pom.xml)"
export IS_RELEASE="$(if [ ${RELEASE_VERSION/SNAPSHOT} = "$RELEASE_VERSION" ] && [ "$TRAVIS_BRANCH" = "master" ]; then echo "true"; fi)"
export BUILD_DOCS="$(if [ "$TRAVIS_JDK_VERSION" = "oraclejdk8" ]; then echo "true"; fi)"
export RUN_ITS="$(if [ "$TRAVIS_JDK_VERSION" = "openjdk7" ]; then echo "true"; fi)"

