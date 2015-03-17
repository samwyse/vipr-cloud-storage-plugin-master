Cloud Storage Plugin
====================

A plugin for uploading build artifacts to, or downloading build dependencies from, EMC Cloud Blob storage. (For a more detailed tutorial see http://go.emc.com/fwlink/?LinkId=280058) 

Installing
----------

This plugin is available in the Jenkins plugin manager. 
To install in Jenkins, go to Manage Jenkins | Manage Plugins | Available | ViPR Cloud Storage Plugin | Install. 
Then restart Jenkins to complete the installation.

Configuration
-------------

At least one Cloud storage account must be configured in the global configuration before the plugin can be used in build steps. To add a storage account, go to Manage Jenkins | Configure System | EMC Cloud Storage Account Configuration and fill out the needed information. 



Post-build actions
==================

Upload artifacts to Cloud
-------------------------

For a more detailed tutorial see: http://go.emc.com/fwlink/?LinkId=280058.

The `Upload artifacts to Cloud` post-build step uploads a build artifact generated by your build to Cloud Blob storage.

1. Select the storage account name to use from the dropdown control
2. Enter a name for the container. A new container will be created if it does not exist. Environment variables can also be referenced. For example: ${JOB_NAME} 
3. Enter the list of artifacts to upload, following the Ant glob syntax. You may create mappings between groups of artifacts and the virtual directory structure for them to be put under in the blob storage using the "::" notation.
4. Optionally, specify the common virtual path under the container that the artifacts will be placed under. This string (followed by a slash '/' character) will follow the container name (after a slash) in the URL for each artifact. Any combination of characters can be used, but reserved URL characters must be properly escaped. Environment variables can also be referenced. For example: "${BUILD_ID}/${BUILD_NUMBER}/"


Build actions
=============

Download from Cloud Blob storage
--------------------------------

The `Download from Cloud blob storage� build step downloads blob contents from Cloud blob storage.

1. Select the storage account name to use from the dropdown control
2. Enter the name of the container to download from. Environment variables can also be referenced. For example: ${JOB_NAME} 
3. Enter the name of the blob to download. You may also use the wild card "*" at the end to select multiple blob downloads sharing the same prefix, for example: project*
4. Optionally, enter the target download path. If not specified, the files will be downloaded into the job's workspace.
Environment variables can also be referenced, for example: ${JOB_NAME}

For a tutorial, see http://go.emc.com/fwlink/?LinkId=280058.


Changelog
=========

Version 0.3.0 September 09, 2014
-----------------------------
- Added easily accessible links for cloud artifacts uploaded to blob storage.

Version 0.2.0 April 23, 2014
----------------------------
- changed the logic of the "make container public" checkbox to apply to newly created containers only
- added a "download from blob" build action
- added a "clean container" option to the artifact uploader post-build action
- some renamings due to branding changes in Cloud (ViPR Cloud changing to EMC Cloud)

Version 0.1.0 February 12, 2013)
--------------------------------
 - Initial release
