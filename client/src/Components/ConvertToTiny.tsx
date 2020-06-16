import React, {FunctionComponent, useEffect, useState} from 'react';
import {Input, Button} from 'antd';
import {CopyOutlined, SyncOutlined} from '@ant-design/icons';
import axios from 'axios'
import CopyToClipboard from 'react-copy-to-clipboard';

interface OwnProps {
    showError: (str: string)=>void,
}

type Props = OwnProps;

const ConvertToTiny: FunctionComponent<Props> = (props) => {

    const [loading, setLoading] = useState(false);
    const [fullUrl, setFullUrl] = useState('')
    const [tinyUrl, setTinyUrl] = useState('')

    const onClick = async (event: React.MouseEvent<HTMLElement>) => {
        if (fullUrl.length && (fullUrl.startsWith('http://') || fullUrl.startsWith('https://'))) {
            setLoading(true)
            axios.post('http://localhost:3005/api/create-tinyurl', {url: fullUrl})
                .then(response => {
                    setTinyUrl(response.data)
                }).catch(error => {
                    props.showError(error.message)})
                .finally(()=>setLoading(false))

        } else {
            props.showError('URL Cannot be empty and should have the pattern of http:// or https:// .')
        }

        event.preventDefault()

    }

    useEffect(()=>{
        //
    },[tinyUrl,fullUrl])

    const onCopyUrl = () => {
        props.showError('Tiny Url copied to clipboard')
    }

    return (
        <div style={{width: '80%'}}>
            <p>Convert to TinyUrl</p>
            <div style={{marginBottom: 16}}>
                <Input defaultValue="" value={fullUrl}
                       onChange={e => setFullUrl(e?.target?.value)}/>
            </div>
            <Button style={{marginBottom: 16}} type="primary" shape="round" icon={<SyncOutlined/>} onClick={onClick}
                    size={'large'} loading={loading}/>
            <div style={{marginBottom: 16}}>
                <Input value={tinyUrl} addonAfter={
                    <CopyToClipboard onCopy={onCopyUrl} text={tinyUrl}>
                        <CopyOutlined/>
                    </CopyToClipboard>
                    }/>
            </div>
            <Button type="primary" danger onClick={()=>{setTinyUrl(''); setFullUrl('')}}>
                Clear
            </Button>
        </div>)
};

export default ConvertToTiny;
