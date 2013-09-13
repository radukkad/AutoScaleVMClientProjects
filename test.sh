#!/bin/sh
echo $1
echo $2


sed -i 's/'"$1"'/'"$2"'/g' /etc/network/interfaces
sed -i 's/'"$3"'/'"$4"'/g' /etc/hosts
sed -i 's/'"$5"'/'"$6"'/g' /etc/hosts
sed -i 's/'"$5"'/'"$6"'/g' /etc/hostname
rm -f /etc/udev/rules.d/70-persistent-net.rules
sed -i 's/managed=false/managed=true/g' /etc/NetworkManager/Networkmanager.conf
reboot
